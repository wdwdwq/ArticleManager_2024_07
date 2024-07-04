package org.example.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Dto {
    protected int id;
    protected String regDate;
}
