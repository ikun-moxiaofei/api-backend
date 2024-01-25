package com.mxf.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author mxf
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}