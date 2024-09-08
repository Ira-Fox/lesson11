package vmarchuk.service;

import java.util.Map;

import vmarchuk.domain.Product;
import vmarchuk.shared.AbstractCRUD;

public interface ProductService extends AbstractCRUD<Product> {
	public Map<Integer, Product> readAllMap();

}
