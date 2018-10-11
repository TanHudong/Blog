package com.thdblog.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/1 0:43
 * @Description
 */
@Entity
@Table(name = "article")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Article {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", columnDefinition = "varchar(64) binary")
    private String id;


    @Column(name = "title")
    private String title;

    @Column(name = "content" , columnDefinition = "text")
    private String content;

    @ManyToOne
    private Category category;

    @Column(name = "summary", columnDefinition = "text")
    private String summary;

    @Column(name = "date", columnDefinition = "varchar(64)")
    private String date;

    @Column(name = "numberOfViews", columnDefinition = "int")
    private int numberOfViews;

}
