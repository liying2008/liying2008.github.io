package cc.duduhuo.jpa.jpatest.m1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/8 18:16
 * Description:
 * Remarks:
 * =======================================================
 */
public interface ModuleRepository extends JpaRepository<Module, Long> {
    List<Module> findModulesByM1(String m1);

    @Query(value = "SELECT m FROM Module m WHERE m.m1 = ?1")
    List<Module> findModulesByM1ForQ(String m1);

    // List<Module> findModulesByOtherOtherId(Long otherId);

    // List<Module> findModulesByOther_OtherId(Long otherId);

    // @Query(value = "SELECT m FROM Module m WHERE m.other.otherId = ?1")
    // List<Module> findModulesByOther_OtherIdForQ(Long otherId);

    @Query(value = "SELECT NEW cc.duduhuo.jpa.jpatest.m1.ModuleWithOther(m, o) FROM Module m LEFT OUTER JOIN Other o ON m.otherId=o.otherId WHERE m.m1=?1")
    List<ModuleWithOther> findModuleWithOthersByM1(String m1);

    // @Query(value = "SELECT m, o FROM Module m LEFT OUTER JOIN Other o ON m.otherId=o.otherId WHERE m.m1=?1")
    // List<Object> findModuleWithOthersByM1(String m1);

}
