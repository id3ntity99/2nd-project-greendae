USE green_univ;
-- 교과과정(lecture)
-- lecture.`id` = 학과코드(3자리) + 과목 고유번호(3자리)
-- 예시: 112(사회복지학과) + 001(사회복지학개론 고유번호) = 112001
-- id, department_id, professor_id, level, classification(Enum("전공", "선택교양")), name, credit, semester
INSERT INTO lecture VALUES
("304001", 304, "P304001", 1, "전공", "C언어", 3, 1, "C언어의 기본적인 문법과 사용법, 프로젝트 빌드에 대해 강의합니다.", "ISBN1234567 - C Programming Language - David Curningham", "건학기념관 201호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304002", 304, "P304001", 1, "전공", "프로그래밍언어론", 3, 1, "프로그래밍 언어의 역사와 인터프리터 및 컴파일러, 문법 등에 대한 강의", "ISBN1234567 - 프로그래밍언어의 이해 - John Doe", "건학기념관 202호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304003", 304, "P304001", 1, "전공", "컴퓨터과학개론", 3, 1, "컴퓨터과학이라는 분야의 기초에 대한 강의", "ISBN1234567 - 컴퓨터과학개론 - John Doe", "건학기념관 203호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304004", 304, "P304001", 1, "전공", "이산수학", 3, 1, "컴퓨터과학을 위한 이산수학 강의", "ISBN1234567 - 이산수학 1 - John Doe", "건학기념관 204호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304005", 304, "P304001", 1, "전공", "인터넷과웹기초", 3, 1, "인터넷과 웹의 기초에 대한 강의.", "ISBN1234567 - 네트워크와 인터넷 - John Doe", "건학기념관 205호", "2025-03-03", "2025-06-23",  "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304006", 304, "P304001", 1, "전공", "컴퓨팅사고와인공지능", 3, 1, "컴퓨팅적, 알고리즘적 사고와 인공지능에 대한 강의", "ISBN1234567 - Algorithmic Thinking - John Doe", "건학기념관 206호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%");

INSERT INTO lecture VALUES
("304007", 304, "P304001", 2, "전공", "자바프로그래밍", 3, 1, "자바 프로그래밍 언어에 대한 강의", "ISBN1234567 - Java Deep Dive - John Doe", "건학기념관 207호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304008", 304, "P304001", 2, "전공", "자료구조", 3, 1, "자료구조에 대한 강의.", "ISBN1234567 - English Communication for Beginner - John Doe", "건학기념관 208호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304009", 304, "P304001", 2, "전공", "컴퓨터구조", 3, 1, "컴퓨터 구조에 대한 강의", "ISBN1234567 - Computer System: Programmer's Perspective - David O'hallaron", "건학기념관 209호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304010", 304, "P304001", 2, "전공", "선형대수", 3, 1, "컴퓨터과학을 위한 선형대수", "ISBN1234567 - 선형대수 1 - John Doe", "건학기념관 210호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304011", 304, "P304001", 2, "전공", "알고리즘", 3, 1, "알고리즘의 기초와 설계, 최적화에 대해 강의힙니다", "ISBN1234567 - Introduction to Algorithm - John Doe", "건학기념관 211호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304012", 304, "P304001", 2, "전공", "HTML/CSS/Javascript", 3, 1, "HTML/CSS/Javascript 기초에 대해 강의합니다..", "ISBN1234567 - Do it! HTML/CSS/Javascript - John Doe", "건학기념관 212호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%");

INSERT INTO lecture VALUES
("304013", 304, "P304001", 3, "전공", "C언어", 3, 1, "C언어의 기본적인 문법과 사용법, 프로젝트 빌드에 대해 강의합니다.", "ISBN1234567 - C Programming Language - David Curningham", "건학기념관 212호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%"),
("304014", 304, "P304001", 3, "전공", "프로그래밍언어론", 3, 1, "프로그래밍 언어의 역사와 인터프리터 및 컴파일러, 문법 등에 대한 강의", "ISBN1234567 - 프로그래밍언어의 이해 - John Doe", "건학기념관 213호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%"),
("304015", 304, "P304001", 3, "전공", "컴퓨터과학개론", 3, 1, "컴퓨터과학이라는 분야의 기초에 대한 강의", "ISBN1234567 - 컴퓨터과학개론 - John Doe", "건학기념관 203호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%"),
("304016", 304, "P304001", 3, "전공", "이산수학", 3, 1, "컴퓨터과학을 위한 이산수학 강의", "ISBN1234567 - 이산수학 1 - John Doe", "건학기념관 204호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%"),
("304017", 304, "P304001", 3, "전공", "인터넷과웹기초", 3, 1, "인터넷과 웹의 기초에 대한 강의.", "ISBN1234567 - 네트워크와 인터넷 - John Doe", "건학기념관 205호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304018", 304, "P304001", 3, "전공", "컴퓨팅사고와인공지능", 3, 1, "컴퓨팅적, 알고리즘적 사고와 인공지능에 대한 강의", "ISBN1234567 - Algorithmic Thinking - John Doe", "건학기념관 206호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%");

INSERT INTO lecture VALUES
("304019", 304, "P304001", 4, "전공", "자바프로그래밍", 3, 1, "자바 프로그래밍 언어에 대한 강의", "ISBN1234567 - Java Deep Dive - John Doe", "건학기념관 207호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%"),
("304020", 304, "P304001", 4, "전공", "자료구조", 3, 1, "자료구조에 대한 강의.", "ISBN1234567 - English Communication for Beginner - John Doe", "건학기념관 208호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%"),
("304021", 304, "P304001", 4, "전공", "컴퓨터구조", 3, 1, "컴퓨터 구조에 대한 강의", "ISBN1234567 - Computer System: Programmer's Perspective - David O'hallaron", "건학기념관 209호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%"),
("304022", 304, "P304001", 4, "전공", "선형대수", 3, 1, "컴퓨터과학을 위한 선형대수", "ISBN1234567 - 선형대수 1 - John Doe", "건학기념관 210호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304023", 304, "P304001", 4, "전공", "알고리즘", 3, 1, "알고리즘의 기초와 설계, 최적화에 대해 강의힙니다", "ISBN1234567 - Introduction to Algorithm - John Doe", "건학기념관 211호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%"),
("304024", 304, "P304001", 4, "전공", "HTML/CSS/Javascript", 3, 1, "HTML/CSS/Javascript 기초에 대해 강의합니다..", "ISBN1234567 - Do it! HTML/CSS/Javascript - John Doe", "건학기념관 212호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%");

INSERT INTO lecture VALUES
("102025", 102, "P102001", 1, "선택교양", "English Communication(1)", 2, 1, "A lecture that is intended to help student's English speaking skill.", "ISBN1234567 - English Communication for Beginner - John Doe", "건학기념관 402호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("105026", 105, "P105001", 1, "선택교양", "세계역사", 2, 1, "A lecture that is intended to help student's English speaking skill.", "ISBN1234567 - English Communication for Beginner - John Doe", "건학기념관 402호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%"),
("101027", 101, "P101001", 1, "선택교양", "고전읽기와토론", 2, 1, "A lecture that is intended to help student's English speaking skill.", "ISBN1234567 - English Communication for Beginner - John Doe", "건학기념관 402호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("109028", 109, "P102001", 1, "선택교양", "인생과철학", 2, 1, "A lecture that is intended to help student's English speaking skill.", "ISBN1234567 - English Communication for Beginner - John Doe", "건학기념관 402호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("304029", 304, "P304001", 1, "선택교양", "기술과의사소통", 2, 1, "A lecture that is intended to help student's English speaking skill.", "ISBN1234567 - English Communication for Beginner - John Doe", "건학기념관 402호", "2025-03-03", "2025-06-23", "중간/기말시험 60%, 과제 30%, 출석 10%"),
("201030", 201, "P201001", 1, "선택교양", "현대사회와수학", 2, 1, "A lecture that is intended to help student's English speaking skill.", "ISBN1234567 - English Communication for Beginner - John Doe", "건학기념관 402호", "2025-03-03", "2025-06-23","중간/기말시험 60%, 과제 30%, 출석 10%");

-- 강의 날짜
INSERT INTO `lecture_day` VALUES 
(1, "304001", "mon");
INSERT INTO `lecture_day` (lecture_id, `day`) VALUES 
("304002", "wed"),
("304003", "fri"),
("304004", "fri"),
("304005", "tue"),
("304006", "mon"),
("304007", "tue"),
("304008", "thur"),
("304009", "wed"),
("304010", "wed"),
("304011", "wed"),
("304012", "tue"),
("304013", "mon"),
("304014", "mon"),
("304015", "mon"),
("304016", "fri"),
("304017", "thur"),
("304018", "thur"),
("304019", "thur"),
("304020", "mon"),
("304021", "mon"),
("304022", "tue"),
("304023", "mon"),
("304024", "wed"),
("102025", "thur"),
("105026", "tue"),
("101027", "tue"),
("109028", "mon"),
("304029", "mon"),
("201030", "mon"),
("304018", "thur"),
("304019", "thur");

-- 강의 시간
-- 강의가 일주일에 2일 진행될 수 있음.
-- 얘를 들어, 자바프로그래밍 강의가 어떤 이유에서 월요일 0900~1100, 목요일 1300~1400에 수업을 진행해야 하는 경우가 발생할 수 도 있으므로
-- lecture_time과 lecture_day를 따로 분리.
INSERT INTO `lecture_time` VALUES
(1, "304001", "09:00:00", "12:00:00");
INSERT INTO `lecture_time` (lecture_id, start_at, end_at) VALUES
("304002", "09:00:00", "12:00:00"),
("304003", "09:00:00", "12:00:00"),
("304004", "09:00:00", "12:00:00"),
("304005", "09:00:00", "12:00:00"),
("304006", "09:00:00", "12:00:00"),
("304007", "09:00:00", "12:00:00"),
("304008", "09:00:00", "12:00:00"),
("304009", "09:00:00", "12:00:00"),
("304010", "09:00:00", "12:00:00"),
("304011", "09:00:00", "12:00:00"),
("304012", "09:00:00", "12:00:00"),
("304013", "09:00:00", "12:00:00"),
("304014", "09:00:00", "12:00:00"),
("304015", "09:00:00", "12:00:00"),
("304016", "09:00:00", "12:00:00"),
("304017", "09:00:00", "12:00:00"),
("304018", "09:00:00", "12:00:00"),
("304019", "09:00:00", "1:00:00"),
("304020", "09:00:00", "12:00:00"),
("304021", "09:00:00", "12:00:00"),
("304022", "09:00:00", "12:00:00"),
("304023", "09:00:00", "12:00:00"),
("304024", "09:00:00", "12:00:00"),
("102025", "09:00:00", "12:00:00"),
("105026", "09:00:00", "12:00:00"),
("101027", "09:00:00", "12:00:00"),
("109028", "09:00:00", "12:00:00"),
("304029", "09:00:00", "12:00:00"),
("201030", "09:00:00", "12:00:00"),
("304018", "09:00:00", "12:00:00"),
("304019", "13:00:00", "14:00:00");


-- 메뉴
INSERT INTO menu VALUES 
(1, "닭안심매콤조림", "바지락미역국", "백미밥", "야끼우동", "두부강정"),
(2, "안심돈까스", "미소된장국", "백미밥", "쫄면", "배추김치"),
(3, "간장게장", "김치찌개", "오곡밥", NULL, NULL);

-- 식단
INSERT INTO meal (menu_id, `date`, `meal_time`) VALUES
(1, "2025-03-17", "lunch"),
(2, "2025-03-18", "lunch"),
(3, "2025-03-19", "lunch"),
(2, "2025-03-20", "lunch"),
(1, "2025-03-21", "lunch"),
(1, "2025-03-17", "breakfast"),
(2, "2025-03-18", "breakfast"),
(3, "2025-03-19", "breakfast"),
(2, "2025-03-20", "breakfast"),
(3, "2025-03-21", "breakfast"),
(3, "2025-03-17", "dinner"),
(2, "2025-03-18", "dinner"),
(1, "2025-03-19", "dinner");

-- 학사일정
INSERT INTO `schedule` VALUES
(1, "대동제", "2025-05-12"),
(2, "개교기념일", "2025-05-30"),
(3, "중간고사", "2025-04-22"),
(4, "중간고사", "2025-04-25"),
(5, "기말고사", "2025-06-17"),
(6, "기말고사", "2025-06-23"),
(7, "근로자의날(휴업일)", "2025-05-01"),
(8, "어린이날, 부처님오신날(휴업일)", "2025-05-05"),
(9, "부처님오신날 대체공휴일(휴업일)", "2025-05-06"),
(10, "성적공시", "2025-06-27"),
(11, "성적공시", "2025-06-30"),
(12, "하계방학, 계절수업 개강", "2025-06-24");

-- 학생정보
INSERT INTO `student` VALUES
("20250001", "hgd123", 112, NULL, 1, 1, 0, 130, "in", "regular", "2025", 1, 1, NULL, "P112001"),
("20250002", "kyh123", 202, NULL, 1, 1, 0, 130, "in", "rolling", "2025", 1, 1, NULL, "P112001"),
("20250003", "kmj123", 406, NULL, 1, 1, 0, 130, "break", "rolling", "2025", 1, 1, NULL, "P112001");

-- 학생회
-- image_id는 각 학생회 소개 페이지에 삽입될 대표 이미지 1장을 위한 컬럼.
INSERT INTO `student_council` VALUES 
(1, "총학생회", "총학생회 입니다.", "instagram.com", NULL),
(2, "인문대학생회", "인문대학생회 입니다.", "instagram.com", NULL),
(3, "공과대학생회", "공과대학생회 입니다.", "instagram.com", NULL),
(4, "자연과학대학생회", "자연과학대학학생회 입니다.", "instagram.com", NULL);

-- registry_lecture
-- 수강신청 대상 과목
INSERT INTO `registry_lecture` VALUES
("101027", 0, 30, NOW()),
("201030", 0, 30, NOW()),
("304008", 0, 30, NOW()),
("304021", 0, 30, NOW()),
("304011", 0, 30, NOW());

-- registry
-- 수강신청 내역. 
-- registry와 registry_lecture는 일대일 관계.
-- 한명의 학생이 여러 강의를 수강할 수는 있지만, 한명의 학생이 하나의 강의를 여러번 신청할 수는 없다.
INSERT INTO `registry` VALUES
("20250001", "101027", "2025", NOW()),
("20250001", "201030","2025", NOW()),
("20250001", "304008","2025", NOW()),
("20250001", "304011","2025", NOW()),
("20250001", "304021","2025", NOW());