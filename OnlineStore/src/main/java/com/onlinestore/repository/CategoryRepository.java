package com.onlinestore.repository;
import com.onlinestore.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
