package com.example.demo.common.rest;

import com.example.demo.constants.enums.ErrorCode;
import com.example.demo.utils.PaginationUtils;
import com.example.demo.utils.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PageResponseDTO<T> extends ResponseDTO {
    private PageableDTO<T> data;

    /**
     * @param page
     * @param <T>
     * @return
     */
    public static <T> PageResponseDTO<T> wrap(Page<T> page) {
        PageResponseDTO<T> dto = new PageResponseDTO<>();

        dto.setData(PageableDTO.wrap(page));
        dto.setCode(ErrorCode.RRM_SUCCESS);

        return dto;
    }

    /**
     * @param data
     * @param page
     * @param size
     * @param code
     * @param <T>
     * @return
     */
    public static <T> PageResponseDTO<T> wrap(List<T> data, int page, int size, ErrorCode code) {
        PageResponseDTO<T> dto = new PageResponseDTO<>();

        dto.setData(PaginationUtils.asPage(data, page, size));
        dto.setCode(code);

        return dto;
    }

    public static <T> PageResponseDTO<T> wrap(List<T> data, int page, int size) {
        return wrap(data, page, size, ErrorCode.RRM_SUCCESS);
    }
}

