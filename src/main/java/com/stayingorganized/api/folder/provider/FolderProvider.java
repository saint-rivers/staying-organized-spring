package com.stayingorganized.api.folder.provider;

import com.stayingorganized.api.folder.model.request.FolderRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class FolderProvider {

    private final String TABLE_NAME = "app_folders";

    public String selectFolderById(@Param("req") FolderRequest folderRequest, boolean hasParent) {
        SQL sql = new SQL();
        sql.INSERT_INTO(TABLE_NAME);
        if (hasParent) {
            sql.VALUES(
                    "name, date_created, parent_id",
                    "#{req.name}, #{req.dateCreated}, #{req.parentId}");
        } else {
            sql.VALUES(
                    "name, date_created",
                    "#{req.name}, #{req.dateCreated}");
        }
        System.out.println(sql);
        return sql + " RETURNING *";
    }

}
