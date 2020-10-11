/**
 * The top level controller for the Senz-API Gateway
 */

import express = require('express')
import bodyParser = require('body-parser')
import cors = require('cors')
import moment from 'moment'
import morgan from 'morgan'

const app: express.Application = express()
const port = process.env.PORT || 3000

app.use(cors())
app.use(bodyParser.json({ limit: '50mb' }))
app.use(bodyParser.urlencoded({ limit: '50mb', extended: false }))

app.use(express.static('public'))
app.use(morgan("common"))

app.get('/time', (_req, res) => {
  res.status(200).send({
    time: moment().format()
  })
})

app.listen(port, () => console.log(`API Gateway listening on PORT ${port}`))

export { app }
