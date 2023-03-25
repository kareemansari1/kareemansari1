package net.cyperts.cfs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cyperts.cfs.entity.NotesForFinancialStatementBSPL;

public interface NotesForFinancialStatementRepository extends JpaRepository<NotesForFinancialStatementBSPL,Integer> {

}
