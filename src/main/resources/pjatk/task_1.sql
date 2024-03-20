# Tasks for Lecture 1

# 1. Show employees who earn more than 2000 and whose surnames do not begin with the letter A. Sort the result by the date of employment.
SELECT * FROM emp WHERE SAL > 2000 AND ename NOT LIKE  'A%' ORDER BY HIREDATE;

# 2. Show employees who earn less than 1500 and whose surnames do not end with the letter S. Sort the result by the date of employment.
SELECT  * FROM  emp WHERE SAL < 1500 AND ENAME NOT LIKE '%S' ORDER BY HIREDATE;

# 3. Show all positions (without repeating).
SELECT DISTINCT JOB from emp;

# 4. Show all employees who have no commission.
SELECT * FROM emp WHERE COMM = 0;

# 5. Show names of those employees who do not have a manager. Include their salaries and positions. Sort the result by salaries.
SELECT ENAME, SAL, JOB from emp WHERE MGR IS NULL ORDER BY  SAL;
