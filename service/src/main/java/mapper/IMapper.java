package mapper;

public interface IMapper<T,R> {

    T mapDtoToEntity(R r);

    R mapEntityToDto(T t);


}
