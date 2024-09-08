package vmarchuk.dao;

import java.util.List;

import vmarchuk.domain.Bucket;
import vmarchuk.shared.AbstractCRUD;

public interface BucketDao extends AbstractCRUD<Bucket> {
	public List<Bucket> readByUserId(Integer id);
}
