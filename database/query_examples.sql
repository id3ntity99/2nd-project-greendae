USE green_univ;

-- 학생지원 >  수강신청 페이지에 나오는 과목들에 대한 쿼리.
SELECT
`dept`.`name` AS `개설학과`,
`lec`.`classification` AS `구분`,
`lec`.`level` AS `학년`,
`lec`.id AS `코드`,
`lec`.`name` AS `과목명`,
`lec`.credit AS `학점`,
`user`.`name` AS `담당교수`,
`reg_lec`.registered_number AS `현재 수강신청 인원수`,
`reg_lec`.max_registered AS `최대 수강신청 인원수`
FROM `registry_lecture` AS `reg_lec`
JOIN `lecture` AS `lec`
ON `reg_lec`.`lecture_id` = `lec`.`id`
JOIN `department` AS  `dept`
ON `dept`.`id` = `lec`.`department_id`
JOIN `professor` AS `prof` 
ON `lec`.professor_id = prof.id
JOIN `user`
ON `user`.id = `prof`.user_id;