package com.thdblog.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/1 0:42
 * @Description
 */
@Entity
@Table(name = "comments")
@NoArgsConstructor
@Setter
@Getter
public class Comments {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", columnDefinition = "varchar(64) binary")
    private String id;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "comm_ip")
    private String commIp;

    @Column(name = "comment", columnDefinition = "text")
    private String comment;

}
