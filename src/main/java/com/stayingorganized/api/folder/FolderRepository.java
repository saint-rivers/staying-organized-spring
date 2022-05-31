package com.stayingorganized.api.folder;

import com.stayingorganized.api.folder.model.request.FolderRequest;
import com.stayingorganized.api.folder.model.Folder;
import com.stayingorganized.api.folder.provider.FolderProvider;
import com.stayingorganized.api.utils.UuidTypeHandler;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface FolderRepository {

    String SELECT_FOLDER_BY_ID = "SELECT * FROM app_folders WHERE id::text = #{folderId} ";

    @Select(SELECT_FOLDER_BY_ID)
    @Results(id = "FolderMap", value = {
            @Result(property = "id", column = "id", typeHandler = UuidTypeHandler.class),
            @Result(property = "dateCreated", column = "date_created"),
            @Result(property = "lastUpdated", column = "last_updated")
    })
    Folder findById(String folderId);

    @SelectProvider(type = FolderProvider.class, method = "selectFolderById")
    @ResultMap("FolderMap")
    Folder insert(@Param("req") FolderRequest folderRequest, boolean hasParent);
}
