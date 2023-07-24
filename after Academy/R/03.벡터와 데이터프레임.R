c(seq(1,5,2),1:10,seq(1,10,2),rep(1:3,2))
data <- c(seq(1,5,2),1:10,seq(1,10,2),rep(1:3,2))
data
iris

irisTemp <- iris[1:5,c(-5)]
irisTemp

# 행과 열을 뒤집기
t(irisTemp)

# iris 데이터의 10의 배수 행만 출력하기
c(seq(10,150,10))
iris[seq(10,nrow(iris),10), ]
iris[1:(nrow(iris)/10)*10 , ]
nrow(iris)
ncol(iris)

iris[1:10,1:2]
iris[1:10,c("Sepal.Length","Sepal.Width")]

colnames(iris)
rownames(iris)

# 기본 통계량
summary(iris)
str(iris)
head(iris)
tail(iris)
