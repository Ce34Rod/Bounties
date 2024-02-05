package org.CERN.bounties.models.data;

import org.CERN.bounties.models.Bounty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BountyRepository extends CrudRepository<Bounty, Integer> {

}
