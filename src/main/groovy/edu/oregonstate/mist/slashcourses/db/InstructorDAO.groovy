package edu.oregonstate.mist.slashcourses.db

import edu.oregonstate.mist.slashcourses.core.Instructor
import edu.oregonstate.mist.slashcourses.mapper.InstructorMapper
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

/**
 * Instructor DAO
 */
@RegisterMapper(InstructorMapper)
public interface InstructorDAO extends Closeable{

    @SqlQuery("""
              SELECT *
              FROM INSTRUCTOR
              WHERE INSTRUCTOR_ID = :instructorId
              """ )
    Instructor getByInstructorID(@Bind("instructorId") Integer instructorId)

    @Override
    void close()
}