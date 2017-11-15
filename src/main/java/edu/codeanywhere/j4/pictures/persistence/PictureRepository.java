package edu.codeanywhere.j4.pictures.persistence;

import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture, Long>
{
    @Query(value="select pic from Picture pic where pic.name=:aName")
    public Picture findPicture(@Param("aName") final String aName);
    @Query(value="Select pic from Picture pic where pic.date= :aDate")
    public Set<Picture> getPicturesByDate(@Param("aDate") final String date);

}

