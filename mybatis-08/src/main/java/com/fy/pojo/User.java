package com.fy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//我们需要将实体类序列化！否则就可能会报错！
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;
}
