package com.huayuan.ops.service;

import com.huayuan.ops.domain.Dictionary;

import java.util.List;

/**
 * Created by dell on 14-3-31.
 */
public interface DictionaryService {
    public List<Dictionary> getBy(final String type);

    public List<Dictionary> getAll();

}
