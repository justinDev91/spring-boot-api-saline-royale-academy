
// package com.salineacademy.api.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.salineacademy.api.entities.User;

// // A mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects
// @Repository
// public interface UserRepository extends JpaRepository<User, Long> {

//    /**
//    * Retrieves the first user with the specified email.
//    *
//    * @param email the email to search for
//    * @return the user with the specified email, or null if not found
//    */
//   User findFirstByEmail(String email);
// }