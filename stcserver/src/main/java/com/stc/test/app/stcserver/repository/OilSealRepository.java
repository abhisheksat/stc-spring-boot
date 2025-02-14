package com.stc.test.app.stcserver.repository;

import com.stc.test.app.stcserver.model.OilSeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OilSealRepository extends JpaRepository<OilSeal, Long> {

    @Query("SELECT o FROM OilSeal o WHERE " +
            "(:innerDiameter IS NULL OR o.innerDiameter = :innerDiameter) AND " +
            "(:outerDiameter IS NULL OR o.outerDiameter = :outerDiameter) AND " +
            "(:thickness IS NULL OR o.thickness = :thickness)")
    List<OilSeal> searchOilSeals(
            @Param("innerDiameter") Double innerDiameter,
            @Param("outerDiameter") Double outerDiameter,
            @Param("thickness") Double thickness);
}