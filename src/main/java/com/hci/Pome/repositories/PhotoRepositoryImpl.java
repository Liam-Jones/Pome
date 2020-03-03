package com.hci.Pome.repositories;

import com.hci.Pome.entities.Photo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


//@Repository

//@Transactional(readOnly = true)
public class PhotoRepositoryImpl implements PhotoRepositoryCustom {}
/*
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Photo> getPhotoGivenTags(String tagName) {

        Query query = entityManager.createQuery("SELECT photo.* FROM pome_data.Photo INNER JOIN pome_data.Tag ON" +
                        " Photo.PhotoID = Photo.PhotoID WHERE PhotoTag.TagID = tagName");

        session.createQuery("select u from Group g inner join g.users u where u.user_name = :userName")
        "SELECT DISTINCT e FROM Employee e INNER JOIN e.tasks t where t.supervisor='Denise'");

        "SELECT p.firstName, p.lastName, n.phoneNumber FROM Person p JOIN PhoneBookEntry n ON p.firstName = n.firstName AND p.lastName = n.lastName"

        Query query = entityManager.createNativeQuery("SELECT em.* FROM spring_data_jpa_example.employee as em " +

                "WHERE em.firstname LIKE ?", Employee.class);

        query.setParameter(1, firstName + "%");

        return query.getResultList();
    }
}





/**

 * Created by gkatzioura on 6/3/16.

 */
/*
@Repository

@Transactional(readOnly = true)

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @PersistenceContext

    EntityManager entityManager;

    @Override

    public List<Employee> getFirstNamesLike(String firstName) {

        Query query = entityManager.createNativeQuery("SELECT em.* FROM spring_data_jpa_example.employee as em " +

                "WHERE em.firstname LIKE ?", Employee.class);

        query.setParameter(1, firstName + "%");

        return query.getResultList();

    }
*/
