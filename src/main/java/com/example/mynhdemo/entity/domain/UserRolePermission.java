package com.example.mynhdemo.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

/**
 * @ClassName：LoginRecord
 * @Author：Acmsdy
 * @Date：2023-12-21 20:24
 * @Describe：
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolePermission {
    private ArrayList<UserRole> ur;
    private ArrayList<PermissionRole> pr;
    private ArrayList<Permission> p;
}
