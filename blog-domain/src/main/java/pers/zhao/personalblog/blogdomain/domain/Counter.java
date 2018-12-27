package pers.zhao.personalblog.blogdomain.domain;

import lombok.Data;
/**
 * 计数器
 * @author zhao
 */
@Data
public class Counter {
    private Integer id;

    private Long count;

    private String keyword;

}