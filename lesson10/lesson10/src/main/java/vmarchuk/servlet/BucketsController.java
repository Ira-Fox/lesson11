package vmarchuk.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import vmarchuk.domain.Bucket;
import vmarchuk.domain.Product;
import vmarchuk.dto.BucketDto;
import vmarchuk.service.BucketService;
import vmarchuk.service.ProductService;
import vmarchuk.service.impl.BucketServiceImpl;
import vmarchuk.service.impl.ProductServiceImpl;

@WebServlet(name = "buckets", urlPatterns = { "/buckets" })
public class BucketsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BucketService bucketService = BucketServiceImpl.getBucketService();
	private ProductService productService = ProductServiceImpl.getProductService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("user_id");
		
		List<Bucket> buckets = bucketService.readByUserId(userId);
		Map<Integer, Product> idToProduct = productService.readAllMap();
		List<BucketDto> listOfBucketDtos = map(buckets, idToProduct);
		
		String json = new Gson().toJson(listOfBucketDtos);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	public List<BucketDto> map(List<Bucket> buckets, Map<Integer, Product> idToProduct) {

		return buckets.stream().map(bucket -> {
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucketId = bucket.getId();
			bucketDto.purchaseDate = bucket.getPurchaseDate();

			Product product = idToProduct.get(bucket.getProductId());
			bucketDto.title = product.getTitle();
			bucketDto.description = product.getDescription();
			bucketDto.price = product.getPrice();

			return bucketDto;
		}).collect(Collectors.toList());

	}

}
