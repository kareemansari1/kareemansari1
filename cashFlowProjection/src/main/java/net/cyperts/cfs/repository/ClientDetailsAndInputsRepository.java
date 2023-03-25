package net.cyperts.cfs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cyperts.cfs.entity.ClientDetailsAndInputs;

public interface ClientDetailsAndInputsRepository extends JpaRepository<ClientDetailsAndInputs, String> {

}
