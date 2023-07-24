search() # comment
help(iris)
# iris 가 무엇일까?? 
# 
iris
head(iris , 10)
example(head)

aaa <- head(iris, 10)
aaa

ls()
rm(aaa)

#산술연산자
1+2
2*3
3-2
22/5
22%%5 # 나눗셈 나머지
22%/%5 # 나눗셈 몫
2**3 # 지수
2^3 # 지수
sqrt(8) # 루트
abs(-10) # 절대값
runif(10) # 난수 10개 생성
trunc(100.5) # 버림
ceiling(100.5) # 올림
round(100.567) # 반올림
round(100.567, 2) # w소수점 두째짜리까지 반올림

floor(runif(10)*100)
ceiling(runif(10)*100)

unique(trunc(runif(6)*45)) # 로또 번호 생성
runif(6,1,45)
trunc(runif(6,1,45)) 

data()

head(Nile) # 나일강 데이터 6개만 가져오기
Nile
hist(Nile) # 데이터로 히스토그램 그리기
plot(Nile) # 산포도
plot(iris$Petal.Length,
     iris$Sepal.Length,
     col=iris$Species)
