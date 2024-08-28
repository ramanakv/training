package com.trg.boot.pub;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
