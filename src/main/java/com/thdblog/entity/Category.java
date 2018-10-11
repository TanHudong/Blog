package com.thdblog.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/1 0:42
 * @Description
 */
@Entity
@Table(name = "category")
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", columnDefinition = "varchar(64) binary")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "display_name")
    private String displayName;

    public Category(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

}
