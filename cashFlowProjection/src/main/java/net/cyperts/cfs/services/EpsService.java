package net.cyperts.cfs.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.cyperts.cfs.entity.Eps;

public interface EpsService {

public List<Eps> getAll();

public void saveEps(MultipartFile file);

}
