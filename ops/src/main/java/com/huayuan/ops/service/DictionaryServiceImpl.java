package com.huayuan.ops.service;

import com.huayuan.ops.domain.Dictionary;
import com.huayuan.ops.repository.DictionaryRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by dell on 14-3-31.
 */
@Service(value = "dictionaryService")
@Transactional
public class DictionaryServiceImpl implements DictionaryService {
    @Inject
    private DictionaryRepository dictionaryRepository;

    @Override
    public List<Dictionary> getBy(String type) {
        return dictionaryRepository.findAll();
    }

    @Override
    @Cacheable(value = "dictionaries")
    public List<Dictionary> getAll() {
        return dictionaryRepository.findAll();
    }
}
