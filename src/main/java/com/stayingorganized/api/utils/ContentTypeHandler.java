package com.stayingorganized.api.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.stayingorganized.api.content.Content;
import org.apache.ibatis.type.MappedTypes;

import java.util.List;


@MappedTypes(Content.class)
public class ContentTypeHandler extends JsonTypeHandler<List<Content>> {

    public ContentTypeHandler() {
        super(new TypeReference<>() {
        });
    }
}
