package net.cyperts.cfs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cyperts.cfs.entity.sample;

public interface SampleRepository extends JpaRepository<sample, Integer> {


}
