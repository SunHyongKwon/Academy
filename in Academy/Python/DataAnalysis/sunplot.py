def makeLine(sub_plot, data, name, color, axis): 
    if axis == 0:
        sub_plot.plot(
        data.columns,
        data.loc[name],
        marker = 'o',
        markerfacecolor = color,
        markersize = 5,
        color = color,
        linewidth = 2,
        label= name
        )

        sub_plot.set_ylim(8000,70000)
        sub_plot.set_xlabel('년도',size= 5)
        sub_plot.set_xticklabels(data.columns,rotation=45,size=6)

        sub_plot.set_ylabel('인구수',size= 5)

        sub_plot.legend(loc='best')
        sub_plot.set_title(f'서울 -> {name}',size = 20)
    else :
        sub_plot.plot(
        data.index,
        data.loc[name],
        marker = 'o',
        markerfacecolor = color,
        markersize = 5,
        color = color,
        linewidth = 2,
        label= name
        )

        sub_plot.set_ylim(8000,70000)
        sub_plot.set_xlabel('년도',size= 5)
        sub_plot.set_xticklabels(data.columns,rotation=45,size=6)

        sub_plot.set_ylabel('인구수',size= 5)

        sub_plot.legend(loc='best')
        sub_plot.set_title(f'서울 -> {name}',size = 20)


def makeSubPlot(fig, data , width , height, place , color , name , axis):
    sub =fig.add_subplot(width, height, place)
    
    makeLine(sub,data,name,color,axis)