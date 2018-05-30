<template>
  <div style="position: inherit; height: 100%;">
    <Layout style="background: white;position: inherit; height: 100%;">
      <Row style="position: inherit;height: 100%;">
        <Col span="4" style="position: inherit;height: 100%;">
          <div style="border: 1px solid #dddee1; margin-right: 5px; position: inherit; height: 100%">
            <div style="font-size: 20px; line-height: 40px;height: 40px; background: #f5f7f9; text-align: center;"><span>资源管理</span></div>
            <Tree :data="menuList" style="text-align: left; padding-left: 10px; padding-top: 10px;" @on-select-change="selectTree"></Tree>
          </div>
        </Col>
        <Col span="20" style="position: inherit; height: 100%">
          <div style="position: inherit; margin-left: 5px; height: 100%;border: 1px solid #dddee1;">
            <div style="text-align: left; padding-left: 10px; font-size: 16px; line-height: 40px;height: 40px; background: #f5f7f9;"><span>资源详情</span></div>
            <Row class="row-line40" align="middle">
              <Col span="8" style="text-align: right; line-height: 40px;">
                资源名称:
              </Col>
              <Col span="16" style="text-align: left; line-height: 40px;">
                <Input type="text" v-model="resource.name" style="width: 220px"></Input>
              </Col>
            </Row>
            <Row>
              <Col span="8" style="text-align: right; line-height: 40px;">
              资源URI:
              </Col>
              <Col span="16" style="text-align: left; line-height: 40px;">
              <Input type="text" v-model="resource.path" style="width: 380px;"></Input>
              </Col>
            </Row>
            <Row>
              <Col span="8" style="text-align: right; line-height: 40px;">
              资源类型:
              </Col>
              <Col span="16" style="text-align: left; line-height: 40px;">
                <Select v-model="resource.type" style="width: 120px">
                  <Option v-for="type in resourceType" :value="type.value" :key="type.value" :label="type.label">{{ type.label }}</Option>
                </Select>
              </Col>
            </Row>
            <Row>
              <Col span="8" style="text-align: right; line-height: 40px;">
              排序:
              </Col>
              <Col span="16" style="text-align: left; line-height: 40px;">
                <Input type="text" v-model="resource.sequence" style="width: 60px;"></Input>
              </Col>
            </Row>
            <Row>
              <Col span="24" style="text-align: center; line-height: 40px;">
                <Button type="success" @click ="resouDataDictionary('resource')">新增</Button>
                <Button type="warning" @click ="warnDataDictionary('resource')">修改</Button>
                <Button type="error" @click ="errDataDictionary('resource')">删除</Button>
              </Col>
            </Row>
          </div>
        </Col>
      </Row>
    </Layout>
    <Spin fix v-if="spinShow">
      <spinner></spinner>
    </Spin>
  </div>
</template>

<script>
import Spinner from '../common/Spinner'
import Input from 'iview/src/components/input/input'

export default {
  components: {
    Input,
    Spinner},
  name: 'menu',
  data () {
    return {
      spinShow: true,
      menuList: [{
        id: 0,
        title: '资源管理',
        children: [],
        type: 1
      }],
      resourceType: [],
      resource: {
        id: null,
        name: null,
        path: null,
        type: null,
        parentId: null,
        sequence: null
      }
    }
  },
  methods: {
    // 数据渲染
    queryDataDictionary () {
      this.$http.post('/api/datadictionary/getDataDictionaryList', {category: 'resourcesType'}).then(response => {
        response.body.info.forEach(entity => {
          entity.value = entity.itemCode
          entity.label = entity.itemName
        })
        this.resourceType = response.body.info
        console.info(response.body.info)// 资源详情
      }, response => {
        console.info(response.body)
      })
    },
    replaceResources (resources) {
      resources.title = resources.name
      console.info(resources.title)// 子节点的title
      resources.children.forEach(resource => {
        resource = this.replaceResources(resource)
      })
      console.info(resources)
      return resources
    },
    queryMenuList () {
      this.$http.post('/api/menu/getResourcesTree', {}).then(response => {
        console.info(response.body.info) // 资源管理下的子节点
        response.body.info.forEach(resources => {
          resources = this.replaceResources(resources)
        })
        this.menuList[0].children = response.body.info
      }, response => {
        console.info(response.body) // 权限管理
      })
    },
    selectTree (node) {
      console.info(node)
      this.resource.name = node[0].name
      // this.resource.path = node[0].path
      this.resource.type = node[0].type.toString()
      this.resource.parentId = node[0].parentId
      this.resource.id = node[0].id
      this.resource.sequence = node[0].sequence
      console.log(this.resource.type)
    },
    // 修改
    warnDataDictionary () {
      console.info(this.alterresource)
      // this.resource.parentId = this.resource.id
      // this.resource.id = null
      this.$http.post('/api/menu/alterResourceId', this.resource).then(response => {
        if (response.ok) {
          this.queryMenuList()
          this.$Message.info('编辑成功')
        } else {
          this.$Message.info('编辑失败')
        }
      })
      this.queryMenuList()
      this.restResource()
    },
    // 新增
    resouDataDictionary () {
      this.resource.parentId = this.resource.id
      console.info(this.resource.id)
      // this.resource.id = null
      this.$http.post('/api/menu/addResource', this.resource).then(response => {
        if (response.ok) {
          this.queryMenuList()
          this.$Message.info('新增成功')
        } else {
          this.$Message.info('新增失败')
        }
      })
      this.queryMenuList()
      this.restResource()
    },
    restResource () {
      this.resource.id = null
      this.resource.name = null
      this.resource.path = null
      this.resource.type = null
      this.resource.parentId = null
      this.resource.sequence = null
    },
    // 删除
    errDataDictionary () {
      this.$http.post('/api/menu/removeResourceById', this.resource).then(response => {
        if (response.ok) {
          this.queryMenuList()
          this.$Message.info('删除成功')
        } else {
          this.$Message.info('删除失败')
        }
      })
      this.queryMenuList()
      this.restResource()
    }
  },
  mounted: function () {
    this.queryDataDictionary()
    this.queryMenuList()
    this.spinShow = false
    // this.queryMenuList()
  }
}
</script>

<style scoped>
  .row-line40{
    height: 40px;
  }
</style>
