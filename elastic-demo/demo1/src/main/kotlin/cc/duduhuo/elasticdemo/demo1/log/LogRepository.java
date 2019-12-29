package cc.duduhuo.elasticdemo.demo1.log;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2019/12/29 20:38
 * Description:
 * Remarks:
 * =======================================================
 */
public interface LogRepository extends ElasticsearchRepository<Log, String> {
    Page<Log> findByUserId(String userId, Pageable pageable);

    Page<Log> findByUserAgent_OsName(String osName, Pageable pageable);
}
