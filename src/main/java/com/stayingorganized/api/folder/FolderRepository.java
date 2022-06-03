package com.stayingorganized.api.folder;

import com.stayingorganized.api.content.Content;
import com.stayingorganized.api.content.ContentUploadRequest;
import com.stayingorganized.api.folder.model.enums.ContentType;
import com.stayingorganized.api.folder.model.request.FolderRequest;
import com.stayingorganized.api.folder.model.Folder;
import com.stayingorganized.api.folder.provider.FolderProvider;
import com.stayingorganized.api.utils.ContentTypeHandler;
import com.stayingorganized.api.utils.UuidTypeHandler;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FolderRepository {

    String SELECT_FOLDER_BY_ID = "SELECT *, id as root_id FROM app_folders WHERE id::text = #{folderId} ";
    String SELECT_SUB_FOLDERS_OF_FOLDER = "SELECT * FROM app_folders WHERE parent_id::text = #{folderId} ";

    @Select(SELECT_FOLDER_BY_ID)
    @Results(id = "FolderMap", value = {
            @Result(property = "id", column = "id", typeHandler = UuidTypeHandler.class),
            @Result(property = "dateCreated", column = "date_created"),
            @Result(property = "lastUpdated", column = "last_updated"),
            @Result(property = "subFolders", column = "root_id", many = @Many(select = "findSubFoldersOfFolder")),
            @Result(property = "content", column = "content", typeHandler = ContentTypeHandler.class)
    })
    Folder findById(String folderId);

    @Select(SELECT_SUB_FOLDERS_OF_FOLDER)
    @ResultMap("FolderMap")
    List<Folder> findSubFoldersOfFolder(String folderId);

    @SelectProvider(type = FolderProvider.class, method = "selectFolderById")
    @ResultMap("FolderMap")
    Folder insert(@Param("req") FolderRequest folderRequest, boolean hasParent);

    @Select("UPDATE app_folders " +
            "SET content = #{content}::jsonb " +
            "WHERE id::text = #{folderId} " +
            "RETURNING id")
    String insertContentToFolder(String content, String folderId);

//    @Select("SELECT content FROM app_folders " +
//            "WHERE id = '9a044cbf-5902-4d42-83bf-2aae0b1bb7a1'")
//    @Result(property = "content")
    List<Content> getContentsOfFolder(String folderId);
}
