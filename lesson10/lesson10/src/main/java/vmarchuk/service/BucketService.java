package vmarchuk.service;

import java.util.List;

import vmarchuk.domain.Bucket;
import vmarchuk.shared.AbstractCRUD;

public interface BucketService extends AbstractCRUD<Bucket> {
	public List<Bucket> readByUserId(Integer id);

}
