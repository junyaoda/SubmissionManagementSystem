package com.example.demo.dto;
import java.io.Serializable;
import lombok.Data;
/**
 * ユーザー情報 検索用リクエストデータ
 */
@Data
public class UserSearchRequest implements Serializable {
    private static final long serialVersionUID = 1L;
	public String password;
    public String name;
}