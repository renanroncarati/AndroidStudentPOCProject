package com.pocstudentproject.services;

import com.pocstudentproject.models.Student;
import com.pocstudentproject.models.StudentListWrapper;

import org.androidannotations.rest.spring.annotations.Accept;
import org.androidannotations.rest.spring.annotations.Body;
import org.androidannotations.rest.spring.annotations.Delete;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Header;
import org.androidannotations.rest.spring.annotations.Headers;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.Rest;
import org.androidannotations.rest.spring.api.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


/**
 * Created by renan on 01/10/2016.
 */

@Rest(rootUrl = "https://parseapi.back4app.com/classes/",converters = { MappingJackson2HttpMessageConverter.class })
@Accept(MediaType.APPLICATION_JSON)
public interface ServiceRest {

    @Headers({
            @Header(name = ServiceConstants.HEADER_PARSE_APPLICATION_ID, value = ServiceConstants.HEADER_PARSE_APPLICATION_ID_VALUE),
            @Header(name = ServiceConstants.HEADER_PARSE_API_KEY, value = ServiceConstants.HEADER_PARSE_API_KEY_VALUE)})
    @Get("aluno")
    StudentListWrapper getStudents();

    @Headers({
            @Header(name = ServiceConstants.HEADER_PARSE_APPLICATION_ID, value = ServiceConstants.HEADER_PARSE_APPLICATION_ID_VALUE),
            @Header(name = ServiceConstants.HEADER_PARSE_API_KEY, value = ServiceConstants.HEADER_PARSE_API_KEY_VALUE)})
    @Post("aluno")
    Student createStudent(@Body Student user);


    @Headers({
            @Header(name = ServiceConstants.HEADER_PARSE_APPLICATION_ID, value = ServiceConstants.HEADER_PARSE_APPLICATION_ID_VALUE),
            @Header(name = ServiceConstants.HEADER_PARSE_API_KEY, value = ServiceConstants.HEADER_PARSE_API_KEY_VALUE)})
    @Delete("aluno/{objectId}")
    void removeStudent(@Path("objectId") String objectId);
}
