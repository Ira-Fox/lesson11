package vmarchuk.service.impl;

import java.util.List;

import vmarchuk.dao.BucketDao;
import vmarchuk.dao.impl.BucketDaoImpl;
import vmarchuk.domain.Bucket;
import vmarchuk.service.BucketService;

public class BucketServiceImpl implements BucketService {
	private static BucketService BucketServiceImpl;
	private BucketDao bucketDao;

	private BucketServiceImpl() {
		bucketDao = new BucketDaoImpl();
	}

	public static BucketService getBucketService() {
		if (BucketServiceImpl == null) {
			BucketServiceImpl = new BucketServiceImpl();
		}

		return BucketServiceImpl;
	}

	@Override
	public Bucket create(Bucket t) {
		return bucketDao.create(t);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket t) {
		return bucketDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}

	@Override
	public List<Bucket> readByUserId(Integer id) {
		return bucketDao.readByUserId(id);
	}

}
