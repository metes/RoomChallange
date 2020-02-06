package com.base.ui.activity

import android.app.Application
import com.base.base.BaseViewModel
import com.base.repository.network.APIClient

class MainActivityVM(app: Application, client: APIClient) : BaseViewModel(app, client)