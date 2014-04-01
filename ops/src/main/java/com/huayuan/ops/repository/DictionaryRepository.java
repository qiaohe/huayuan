package com.huayuan.ops.repository;

import com.huayuan.ops.domain.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dell on 14-4-1.
 */
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
}
