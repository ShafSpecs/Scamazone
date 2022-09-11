package com.nigerians.scamazone.data.respositories;

import com.nigerians.scamazone.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}