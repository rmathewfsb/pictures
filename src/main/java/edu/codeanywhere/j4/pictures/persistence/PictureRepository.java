/*
 *    Copyright &copy; Flagstar Bank 2017.
 *
 *    Copyright in the application source code, and in the information and
 *    material therein and in their arrangement, is owned by Flagstar Bank, FSB
 *    unless otherwise indicated.
 *
 *    You shall not remove or obscure any copyright, trademark or other notices.
 *    You may not copy, republish, redistribute, transmit, participate in the
 *    transmission of, create derivatives of, alter edit or exploit in any
 *    manner any material including by storage on retrieval systems, without the
 *    express written permission of Flagstar Bank.
 */
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

