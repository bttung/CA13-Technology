/*1*/
select * from emp order by empno desc;

/*2*/
select count(distinct deptno) from emp;

/*3-1*/
select deptno, count(deptno) as count from emp group by deptno;

/*3-2*/
select d.dept_name, count(e.deptno) from dept d left outer join emp e on e.deptno = d.deptno group by e.deptno;
select d.dept_name, count(e.empno) from dept d left outer join emp e on e.deptno = d.deptno group by d.dept_name;

/*4*/
select e.empno, e.emp_name, d.dept_name from dept d left outer join emp e on d.deptno = e.deptno;

/*5*/
select d.dept_name from dept d left join emp e on d.deptno = e.deptno where e.empno is null;
select d.dept_name from dept d where not exists ( select * from emp e where e.deptno = d.deptno );

/*Š‘®l”‚ªˆê”Ô‘½‚¢•”‚Ì–¼‘O*/
select d.dept_name from dept d left outer join emp e on d.deptno = e.deptno group by d.dept_name 
having count(*) >= all (select count(*) from dept d left outer join emp e on d.deptno = e.deptno group by d.dept_name);


