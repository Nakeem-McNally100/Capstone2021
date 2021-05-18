examplepredictiondata = [128.71623, 128.57799, 128.77603, 129.33626, 130.38635, 132.01085, 134.21452,
                         [128.22418212890625, 128.53614807128906, 128.96945190429688, 129.53887939453125,
                          130.1899871826172, 130.97927856445312, 131.9606475830078, 133.00732421875, 134.02059936523438,
                          134.9370574951172, 135.81387329101562, 136.56809997558594, 137.2023162841797, 137.69808959960938, 138.03536987304688,
                          138.23866271972656, 138.26976013183594, 138.17286682128906, 138.0367431640625, 137.85643005371094, 137.61236572265625,
                          137.4772186279297, 137.39862060546875, 137.25315856933594, 137.01708984375, 136.61001586914062, 136.0522918701172,
                          135.39524841308594, 134.75564575195312, 134.19273376464844, 133.73220825195312],
                         [136.5500030517578, 136.33999633789062,137.72000122070312, 138.67999267578125, 138.4199981689453, 137.77000427246094, 139.13999938964844, 137.82000732421875,
                    138.6999969482422, 140.16000366210938, 138.85000610351562, 138.7899932861328, 137.85000610351562, 137.0500030517578,
                137.25999450683594, 135.8000030517578, 134.77999877929688, 133.60000610351562, 131.92999267578125, 131.00999450683594,
                130.0, 132.24000549316406, 133.08999633789062, 128.3800048828125, 130.36000061035156, 128.2100067138672, 128.97000122070312,
                 128.7899932861328, 128.9499969482422, 129.02999877929688, 129.57000732421875]]



def prepPredictions(lst):
    
    sevenfuturedays = lst[0:7]
    thirtydaysPrediction = lst[7]
    thirtydaysActual = lst[8]
    sevenfuturedaystring = ""
    thirtydaysPredictionString = ""
    thirtydaysActualstring = ""

    for x in sevenfuturedays:
        sevenfuturedaystring = sevenfuturedaystring + "-" + str(x)
        
    for i in thirtydaysPrediction:
        thirtydaysPredictionString = thirtydaysPredictionString + "-"+ str(i)

    for y in thirtydaysActual:
        thirtydaysActualstring = thirtydaysActualstring + "-" + str(y)
        

    return [sevenfuturedaystring[1:], thirtydaysPredictionString[1:],thirtydaysActualstring[1:]]


