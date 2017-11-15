package edu.codeanywhere.j4.pictures.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
public interface MongoUserDetailsRepository extends MongoRepository<MongoUserDetails, String>
{
    MongoUserDetails findByUsername(final String username);
}

