package service;

import dto.AuthorDto;
import mapper.IMapper;

import java.util.List;

public interface IAuthorService {

    List<AuthorDto> getAllAuthors();
}
