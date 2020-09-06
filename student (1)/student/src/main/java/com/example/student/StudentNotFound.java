package com.example.student;

public class StudentNotFound extends RuntimeException
{
    public StudentNotFound(String exception) {
        super(exception);
    }
}
