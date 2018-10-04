package com.thdblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/5 0:02
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForm {
    private String id;
    private String categoryName;
    private String categoryDisplayName;
}
